package cn.hlb.platform.system.provider.serviceimpl;

import cn.hlb.platform.system.api.service.ICurrencyRateService;
import cn.hlb.platform.system.provider.thirdapi.YahooRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 汇率服务
 *
 * @author hlb
 */
@Service
@Transactional(readOnly = true)
public class CurrencyRateService implements ICurrencyRateService {

    /**
     * yahoo 汇率服务
     */
    @Autowired
    private YahooRateService yahooRateService;

    @Override
    public Map<String, String> getRate() {
        return yahooRateService.get();
    }
}
