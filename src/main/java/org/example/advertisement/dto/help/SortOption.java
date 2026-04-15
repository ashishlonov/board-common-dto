package org.example.advertisement.dto.help;

/**
 * Варианты сортировки при поиске объявлений.
 *
 * <ul>
 *   <li><b>DATE_DESC</b> - сначала новые (по убыванию даты).</li>
 *   <li><b>DATE_ASC</b> - сначала старые (по возрастанию даты).</li>
 *   <li><b>COST_ASC</b> - от дешёвых к дорогим.</li>
 *   <li><b>COST_DESC</b> - от дорогих к дешёвым.</li>
 * </ul>
 */
public enum SortOption {
    DATE_DESC, DATE_ASC, COST_ASC, COST_DESC
}
