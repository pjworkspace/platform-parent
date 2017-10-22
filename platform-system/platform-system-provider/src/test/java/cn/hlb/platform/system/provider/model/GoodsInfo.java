package cn.hlb.platform.system.provider.model;

import java.util.Date;

public class GoodsInfo {
    /**
     * 编号
     */
    private String id;

    /**
     * 商家id
     */
    private String supplier_id;

    /**
     * 商品分类code
     */
    private String goods_type_code;

    /**
     * 商品名称
     */
    private String goods_name;

    /**
     * 商品品牌
     */
    private String goods_brand;

    /**
     * 商品价格,单位:分
     */
    private Long goods_price;

    /**
     * 商品状态code
     */
    private String goods_status_code;

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
     * 获取商家id
     *
     * @return supplier_id - 商家id
     */
    public String getSupplier_id() {
        return supplier_id;
    }

    /**
     * 设置商家id
     *
     * @param supplier_id 商家id
     */
    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id == null ? null : supplier_id.trim();
    }

    /**
     * 获取商品分类code
     *
     * @return goods_type_code - 商品分类code
     */
    public String getGoods_type_code() {
        return goods_type_code;
    }

    /**
     * 设置商品分类code
     *
     * @param goods_type_code 商品分类code
     */
    public void setGoods_type_code(String goods_type_code) {
        this.goods_type_code = goods_type_code == null ? null : goods_type_code.trim();
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoods_name() {
        return goods_name;
    }

    /**
     * 设置商品名称
     *
     * @param goods_name 商品名称
     */
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name == null ? null : goods_name.trim();
    }

    /**
     * 获取商品品牌
     *
     * @return goods_brand - 商品品牌
     */
    public String getGoods_brand() {
        return goods_brand;
    }

    /**
     * 设置商品品牌
     *
     * @param goods_brand 商品品牌
     */
    public void setGoods_brand(String goods_brand) {
        this.goods_brand = goods_brand == null ? null : goods_brand.trim();
    }

    /**
     * 获取商品价格,单位:分
     *
     * @return goods_price - 商品价格,单位:分
     */
    public Long getGoods_price() {
        return goods_price;
    }

    /**
     * 设置商品价格,单位:分
     *
     * @param goods_price 商品价格,单位:分
     */
    public void setGoods_price(Long goods_price) {
        this.goods_price = goods_price;
    }

    /**
     * 获取商品状态code
     *
     * @return goods_status_code - 商品状态code
     */
    public String getGoods_status_code() {
        return goods_status_code;
    }

    /**
     * 设置商品状态code
     *
     * @param goods_status_code 商品状态code
     */
    public void setGoods_status_code(String goods_status_code) {
        this.goods_status_code = goods_status_code == null ? null : goods_status_code.trim();
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