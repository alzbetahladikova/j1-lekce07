package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */
  @Test
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu() {
    Svatky svatky = new Svatky();
    assertTrue(svatky.jeVSeznamu("Nataša"));
    assertFalse(svatky.jeVSeznamu("paosidhf"));
    }



  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getPocetJmen());
  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */
  @Test
  void getSeznamJmen() {
    Svatky svatky = new Svatky();
    assertNotNull(svatky.getSeznamJmen());
    assertEquals(37, svatky.getSeznamJmen().size());
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Laura", 1, 6);
    assertEquals(MonthDay.of(6, 1), svatky.kdyMaSvatek("Laura"));
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Jarmil", 2, Month.JUNE);
    assertEquals(MonthDay.of(6, 2), svatky.kdyMaSvatek("Jarmil"));
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void prridatSvatekMonthDay() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Kevin", MonthDay.of(Month.JUNE, 3));
    assertEquals(MonthDay.of(6, 3), svatky.kdyMaSvatek("Kevin"));
  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    Svatky svatky = new Svatky();
    int pocetSvatkuPoSmazani = svatky.getPocetJmen()-1;
    String jmeno="Nataša";
    assertTrue(svatky.jeVSeznamu(jmeno));
    svatky.smazatSvatek(jmeno);
    assertFalse(svatky.jeVSeznamu(jmeno));
    assertEquals(pocetSvatkuPoSmazani, svatky.getPocetJmen());
  }
}
