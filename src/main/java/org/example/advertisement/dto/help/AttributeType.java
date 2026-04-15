package org.example.advertisement.dto.help;

/**
 * Типы значений атрибутов категорий.
 *
 * <ul>
 *   <li><b>STRING</b> - произвольная строка текста.</li>
 *   <li><b>INTEGER</b> - целое число.</li>
 *   <li><b>DECIMAL</b> - дробное число.</li>
 *   <li><b>BOOLEAN</b> - да/нет (true/false).</li>
 *   <li><b>SELECT</b> - выбор одного варианта из списка.</li>
 *   <li><b>MULTISELECT</b> - выбор нескольких вариантов из списка.</li>
 *   <li><b>DATE</b> - дата.</li>
 * </ul>
 */
public enum AttributeType {
    STRING, INTEGER, DECIMAL, BOOLEAN, SELECT, MULTISELECT, DATE
}