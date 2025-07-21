package ntp.springaifirst.enums;

public enum ToneStyle {
    FRIENDLY("Hãy dùng giọng điệu thân thiện và gần gũi."),
    PROFESSIONAL("Hãy trả lời một cách chuyên nghiệp, ngắn gọn và đúng trọng tâm."),
    CASUAL("Nói chuyện như một người bạn bình thường, dùng ngôn ngữ tự nhiên.");

    private String value;

    private ToneStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
