package org.example.advertisement.dto.help;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Географический адрес объявления.
 *
 * <p>Поля: country — страна, city — город, street — улица,
 * houseNumber — номер дома, formattedAddress — полный отформатированный адрес.</p>
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Location {
    @NotBlank(message = "Страна обязательна")
    @Size(max = 100, message = "Название страны не более 100 символов")
    private String country;
    @NotBlank(message = "Город обязателен")
    @Size(max = 100, message = "Название города не более 100 символов")
    private String city;
    @Size(max = 100, message = "Название улицы не более 100 символов")
    private String street;
    @Size(max = 10, message = "Номер дома не более 20 символов")
    private String houseNumber;
    //    private BigDecimal latitude;
//    private BigDecimal longitude;
//    private String placeId;
    @Size(max = 500, message = "Адрес не более 500 символов")
    private String formattedAddress;
}