package com.aliyun.oss;

import com.aliyun.oss.common.comm.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;

/**
 * 描述: aliyun oss 自动配置
 * 包名: com.aliyun.oss.
 */
@ConditionalOnClass(OSSClient.class)
@EnableConfigurationProperties(OSSProperties.class)
public class OSSAutoConfiguration {

  @Autowired
  OSSProperties ossProperties;

  private OSSClient ossClientForUpload;

  private OSSClient ossClientForManager;

  @PreDestroy
  public void close() {
    if (this.ossClientForUpload != null) {
      this.ossClientForUpload.shutdown();
    }
    if (this.ossClientForManager != null) {
      this.ossClientForManager.shutdown();
    }
  }

  @Bean(name = "clientConfiguration")
  @ConditionalOnMissingBean
  public ClientConfiguration clientConfiguration(OSSProperties ossProperties) {
    Client client = ossProperties.getClient();
    ClientConfiguration configuration = new ClientConfiguration();
    configuration.setMaxConnections(client.getMaxConnections());
    configuration.setSocketTimeout(client.getSocketTimeout());
    configuration.setConnectionTimeout(client.getConnectionTimeout());
    configuration.setConnectionRequestTimeout(client.getConnectionRequestTimeout());
    client.setIdleConnectionTime(client.getIdleConnectionTime());
    configuration.setMaxErrorRetry(client.getMaxErrorRetry());
    configuration.setSupportCname(client.isSupportCname());
    configuration.setSLDEnabled(client.isSldEnabled());
    if (Protocol.HTTP.toString().equals(client.getProtocol())) {
      configuration.setProtocol(Protocol.HTTP);
    } else if (Protocol.HTTPS.toString().equals(client.getProtocol())) {
      configuration.setProtocol(Protocol.HTTPS);
    }
    configuration.setUserAgent(client.getUserAgent());

    return configuration;
  }

  @Bean(name = "ossClientForUpload")
  public OSSClient ossClientForUpload(OSSProperties oSSProperties, ClientConfiguration clientConfiguration) {
    ossClientForUpload = new OSSClient(oSSProperties.getEndpointUpload(), oSSProperties.getAccessKeyId(), oSSProperties
     .getAccessKeySecret(), clientConfiguration);
    return ossClientForUpload;
  }

  @Bean(name = "ossClientForManager")
  public OSSClient ossClientForManager(OSSProperties oSSProperties, ClientConfiguration clientConfiguration) {
    ossClientForManager = new OSSClient(oSSProperties.getEndpointManager(), oSSProperties
     .getAccessKeyId(), oSSProperties.getAccessKeySecret(), clientConfiguration);
    return ossClientForManager;
  }
}
