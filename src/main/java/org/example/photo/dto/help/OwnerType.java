package org.example.photo.dto.help;

/**
 * Тип владельца фотографии — к чему относится фото.
 *
 * <ul>
 *   <li><b>USER</b> - фото принадлежит пользователю (аватар).</li>
 *   <li><b>ADVERTISEMENT</b> - фото привязано к объявлению.</li>
 *   <li><b>VERIFICATION_DOC</b> - фото является документом для верификации компании.</li>
 * </ul>
 */
public enum OwnerType {
    USER, ADVERTISEMENT, VERIFICATION_DOC
}
