package cn.hlb.platform.system.provider.model;

import java.util.Date;

public class SupplierInfo {
    /**
     * 编号
     */
    private String id;

    /**
     * 店铺名称
     */
    private String shop_name;

    /**
     * 负责人姓名
     */
    private String charge_name;

    /**
     * 身份证号码
     */
    private String id_card;

    /**
     * 营业执照url地址
     */
    private String llicense_url;

    /**
     * 营业执照是否上传  0:是  1:营业执照正在办理
     */
    private String license_flag;

    /**
     * 营业业务code
     */
    private String bussiness_code;

    /**
     * 省份Id
     */
    private String province_id;

    /**
     * 城市Id
     */
    private String city_id;

    /**
     * 区县id
     */
    private String area_id;

    /**
     * 商家门头照url地址
     */
    private String head_picture_url;

    /**
     * 营业开始时间
     */
    private String start_time;

    /**
     * 营业结束时间
     */
    private String end_time;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 审核状态 0:审核通过  1:未通过  2:申请开通
     */
    private String status;

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
     * 获取店铺名称
     *
     * @return shop_name - 店铺名称
     */
    public String getShop_name() {
        return shop_name;
    }

    /**
     * 设置店铺名称
     *
     * @param shop_name 店铺名称
     */
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    /**
     * 获取负责人姓名
     *
     * @return charge_name - 负责人姓名
     */
    public String getCharge_name() {
        return charge_name;
    }

    /**
     * 设置负责人姓名
     *
     * @param charge_name 负责人姓名
     */
    public void setCharge_name(String charge_name) {
        this.charge_name = charge_name == null ? null : charge_name.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getId_card() {
        return id_card;
    }

    /**
     * 设置身份证号码
     *
     * @param id_card 身份证号码
     */
    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    /**
     * 获取营业执照url地址
     *
     * @return llicense_url - 营业执照url地址
     */
    public String getLlicense_url() {
        return llicense_url;
    }

    /**
     * 设置营业执照url地址
     *
     * @param llicense_url 营业执照url地址
     */
    public void setLlicense_url(String llicense_url) {
        this.llicense_url = llicense_url == null ? null : llicense_url.trim();
    }

    /**
     * 获取营业执照是否上传  0:是  1:营业执照正在办理
     *
     * @return license_flag - 营业执照是否上传  0:是  1:营业执照正在办理
     */
    public String getLicense_flag() {
        return license_flag;
    }

    /**
     * 设置营业执照是否上传  0:是  1:营业执照正在办理
     *
     * @param license_flag 营业执照是否上传  0:是  1:营业执照正在办理
     */
    public void setLicense_flag(String license_flag) {
        this.license_flag = license_flag == null ? null : license_flag.trim();
    }

    /**
     * 获取营业业务code
     *
     * @return bussiness_code - 营业业务code
     */
    public String getBussiness_code() {
        return bussiness_code;
    }

    /**
     * 设置营业业务code
     *
     * @param bussiness_code 营业业务code
     */
    public void setBussiness_code(String bussiness_code) {
        this.bussiness_code = bussiness_code == null ? null : bussiness_code.trim();
    }

    /**
     * 获取省份Id
     *
     * @return province_id - 省份Id
     */
    public String getProvince_id() {
        return province_id;
    }

    /**
     * 设置省份Id
     *
     * @param province_id 省份Id
     */
    public void setProvince_id(String province_id) {
        this.province_id = province_id == null ? null : province_id.trim();
    }

    /**
     * 获取城市Id
     *
     * @return city_id - 城市Id
     */
    public String getCity_id() {
        return city_id;
    }

    /**
     * 设置城市Id
     *
     * @param city_id 城市Id
     */
    public void setCity_id(String city_id) {
        this.city_id = city_id == null ? null : city_id.trim();
    }

    /**
     * 获取区县id
     *
     * @return area_id - 区县id
     */
    public String getArea_id() {
        return area_id;
    }

    /**
     * 设置区县id
     *
     * @param area_id 区县id
     */
    public void setArea_id(String area_id) {
        this.area_id = area_id == null ? null : area_id.trim();
    }

    /**
     * 获取商家门头照url地址
     *
     * @return head_picture_url - 商家门头照url地址
     */
    public String getHead_picture_url() {
        return head_picture_url;
    }

    /**
     * 设置商家门头照url地址
     *
     * @param head_picture_url 商家门头照url地址
     */
    public void setHead_picture_url(String head_picture_url) {
        this.head_picture_url = head_picture_url == null ? null : head_picture_url.trim();
    }

    /**
     * 获取营业开始时间
     *
     * @return start_time - 营业开始时间
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * 设置营业开始时间
     *
     * @param start_time 营业开始时间
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time == null ? null : start_time.trim();
    }

    /**
     * 获取营业结束时间
     *
     * @return end_time - 营业结束时间
     */
    public String getEnd_time() {
        return end_time;
    }

    /**
     * 设置营业结束时间
     *
     * @param end_time 营业结束时间
     */
    public void setEnd_time(String end_time) {
        this.end_time = end_time == null ? null : end_time.trim();
    }

    /**
     * 获取联系方式
     *
     * @return phone - 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系方式
     *
     * @param phone 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取审核状态 0:审核通过  1:未通过  2:申请开通
     *
     * @return status - 审核状态 0:审核通过  1:未通过  2:申请开通
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置审核状态 0:审核通过  1:未通过  2:申请开通
     *
     * @param status 审核状态 0:审核通过  1:未通过  2:申请开通
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}