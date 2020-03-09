package org.example;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class HumanAssertTest {

    @Test
    public void firstTest() {
        BigDecimal weight = new BigDecimal(60.2).setScale(1, BigDecimal.ROUND_HALF_UP);
        List<String> jobs = Arrays.asList("Artist", "Writer", "Killer");
        HumanAssert jora = new HumanAssert("Jora", 20, weight, jobs);
        assertThat(jora)
                .as("Проверка ниличия имени").hasFieldOrProperty("name")
                .as("Проверка наличия возраста").hasFieldOrProperty("weight")
                .as("Проверка имени").hasFieldOrPropertyWithValue("name", "Jora")
                .as("Проверка класса").isInstanceOf(HumanAssert.class);
        assertThat(jora.getJobs())
                .as("Содержит данные профессии").contains("Writer", "Killer")
                .as("Содерижт хотя бы одну из профессий").containsAnyOf("Хирург", "Writer")
                .as("100% совпадение профессий").containsExactly("Artist", "Writer", "Killer");
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(jora.getName()).as("Имя").isEqualTo("Jora");
        soft.assertAll();
    }
}
