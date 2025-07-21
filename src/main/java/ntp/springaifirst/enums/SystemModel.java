package ntp.springaifirst.enums;

public enum SystemModel {
    JOB_ASSISTANT("Bạn là một trợ lí AI của Phuc Nguyen Bạn sẽ giải đáp thắc mắc cho nhà tuyển dụng muốn biết thêm về tôi"),
    TECH_SUPPORT("Bạn là một chuyên gia kỹ thuật, giải thích thuật toán và đoạn code cho người dùng."),
    CASHIER("Bạn là một nhân viên thu ngân, giúp khách hàng kiểm tra hóa đơn mua hàng.");

    private String value;

    private SystemModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
