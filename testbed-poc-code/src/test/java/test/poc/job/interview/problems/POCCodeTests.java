package test.poc.job.interview.problems;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import poc.job.interview.problems.POCCode;


@RunWith(SpringRunner.class)
public class POCCodeTests {
	
	@InjectMocks
	private POCCode pocCode;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSizes() {
		assertThat(pocCode.sizes("LSMSLMS")).isEqualTo("SSSMMLL");
	}
	
	@Test
	public void testSmallestInt() {
		int[] testArray = {1,2,3,4,6,7,8,9,10};
		assertThat(pocCode.smallestInt(testArray)).isEqualTo(5);
	}
	
	@Test
	public void testDaysAhead() {
		assertThat(pocCode.daysAhead("Wed", 123)).isEqualTo("Sun");
	}
	
	@Test
	public void testGetFirstNonRepeatingHappyPath() {
		assertThat(pocCode.getFirstNonRepeating("abc")).isEqualTo("a");
	}
	
	@Test
	public void testGetFirstNonRepeatingNullInput() {
		assertThat(pocCode.getFirstNonRepeating(null)).isNull();
	}
	
	@Test
	public void testGetFirstNonRepeatingNoNonRepeats() {
		assertThat(pocCode.getFirstNonRepeating("aabbcc")).isNull();
	}
	
	@Test
	public void testGetFirstNonRepeatingWithRepeats() {
		assertThat(pocCode.getFirstNonRepeating("aabcc")).isEqualTo("b");
	}
	
	@Test
	public void testGetFirstNonRepeatingCaseInsensitive() {
		assertThat(pocCode.getFirstNonRepeating("aABcC")).isEqualTo("b");
	}
	
	@Test
	public void testGetFirstNonRepeatingWithSpaces() {
		assertThat(pocCode.getFirstNonRepeating("a a b c c")).isEqualTo("b");
	}
	
	@Test
	public void testGetFirstNonRepeatingWithOneSpace() {
		assertThat(pocCode.getFirstNonRepeating("a abcc")).isEqualTo("b");
	}
	
	@Test
	public void testGetFirstNonRepeatingSentenceTest() {
		assertThat(pocCode.getFirstNonRepeating("The quick brown fox jumped over the lazy dogs back")).isEqualTo("q");
	}
	
	@Test
	public void testMaxMinAddHappyPath() {
		int[] input = {1,2,3,4,5};
		
		Map<String, Integer> test = pocCode.maxMinAdd(input);
		
		assertThat(test.get("Min")).isEqualTo(10);
		assertThat(test.get("Max")).isEqualTo(14);
	}
	
	@Test
	public void testMaxMinAddAllZeroes() {
		int[] input = {0,0,0,0,0,0,0,0};
		
		Map<String, Integer> test = pocCode.maxMinAdd(input);
		
		assertThat(test.get("Min")).isEqualTo(0);
		assertThat(test.get("Max")).isEqualTo(0);
	}
	
	@Test
	public void testMaxMinAddAllNines() {
		int[] input = {9,9,9,9,9,9,9,9,9,9};
		
		Map<String, Integer> test = pocCode.maxMinAdd(input);
		
		assertThat(test.get("Min")).isEqualTo(81);
		assertThat(test.get("Max")).isEqualTo(81);
	}
	
	@Test
	public void testMaxMinAddNullInput() {		
		Map<String, Integer> test = pocCode.maxMinAdd(null);
		
		assertThat(test.get("Min")).isEqualTo(0);
		assertThat(test.get("Max")).isEqualTo(0);
	}

}
