package ntp.springaifirst.dto;

public record BillItems(String name,
                        Integer quantity,
                        Integer price,
                        String subject,
                        Integer price_total) {
}
