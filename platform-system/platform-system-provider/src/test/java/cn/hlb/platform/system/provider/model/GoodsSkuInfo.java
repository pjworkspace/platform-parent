package cn.hlb.platform.system.provider.model;

import java.util.Date;

public class GoodsSkuInfo {
    /**
     * 编号
     */
    private String id;

    /**
     * 商品ID
     */
    private String goods_id;

    /**
     * 规格名称
     */
    private String sku_name;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 更新时间
     */
    private Date update_date;

    /**
     * 删除标记
            3：删除
            0：未删除
     */
    private String del_flag;

    private String create_user_id;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public String getGoods_id() {
        return goods_id;
    }

    /**
     * 设置商品ID
     *
     * @param goods_id 商品ID
     */
    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id == null ? null : goods_id.trim();
    }

    /**
     * 获取规格名称
     *
     * @return sku_name - 规格名称
     */
    public String getSku_name() {
        return sku_name;
    }

    /**
     * 设置规格名称
     *
     * @param sku_name 规格名称
     */
    public void setSku_name(String sku_name) {
        this.sku_name = sku_name == null ? null : sku_name.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * 设置创建时间
     *
     * @param create_date 创建时间
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * 设置更新时间
     *
     * @param update_date 更新时间
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /**
     * 获取删除标记
            3：删除
            0：未删除
     *
     * @return del_flag - 删除标记
            3：删除
            0：未删除
     */
    public String getDel_flag() {
        return del_flag;
    }

    /**
     * 设置删除标记
            3：删除
            0：未删除
     *
     * @param del_flag 删除标记
            3：删除
            0：未删除
     */
    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag == null ? null : del_flag.trim();
    }

    /**
     * @return create_user_id
     */
    public String getCreate_user_id() {
        return create_user_id;
    }

    /**
     * @param create_user_id
     */
    public void setCreate_user_id(String create_user_id) {
        this.create_user_id = create_user_id == null ? null : create_user_id.trim();
    }
}