import org.testng.annotations.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SortingTest {

    @Test
    public void gnomeSort() {
        Sorting st = new Sorting();
        Integer[] nums = new Integer[1000];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(20);
        }
        for (Integer num : nums) {
            System.out.println(num);
        }
        System.out.println("--------------------");
        st.gnomeSort(nums);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }

    @Test
    public void mergeSort() {
        Sorting st = new Sorting();
        Integer[] nums = new Integer[1000];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(20);
        }
        for (Integer num : nums) {
            System.out.println(num);
        }
        System.out.println("--------------------");
        st.mergeSort(nums);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}