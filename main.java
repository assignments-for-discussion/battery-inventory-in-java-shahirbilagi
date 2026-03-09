public class Main {

  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  }

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {

    final int RATED_CAPACITY = 120;
    CountsBySoH counts = new CountsBySoH();

    for (int capacity : presentCapacities) {

      double soh = (capacity * 100.0) / RATED_CAPACITY;

      if (soh > 83 && soh <= 100) {
        counts.healthy++;
      }
      else if (soh >= 63 && soh <= 83) {
        counts.exchange++;
      }
      else {
        counts.failed++;
      }
    }

    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");

    int[] presentCapacities = {92,89,70,90,119,70};

    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert counts.healthy == 1 : "Healthy count should be 1";
    assert counts.exchange == 3 : "Exchange count should be 3";
    assert counts.failed == 2 : "Failed count should be 2";


    System.out.println("Healthy Batteries : " + counts.healthy);
    System.out.println("Exchange Batteries: " + counts.exchange);
    System.out.println("Failed Batteries  : " + counts.failed);

  }
  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
