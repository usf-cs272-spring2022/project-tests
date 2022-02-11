package edu.usfca.cs272;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;

/**
 * Tests that next project code is not in the current project. This class should
 * not be run directly; it is run by GitHub Actions only.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Spring 2022
 */
public class ProjectNextTests extends ProjectTests {
	/**
	 * Message output when a test fails.
	 */
	public static final String debug = "You must place functionality for the next project in a separate branch. It should not be in the current version of your project in the main branch!";

	/**
	 * Tests that next project functionality is not present.
	 *
	 * @throws IOException if an IO error occurs
	 */
	@Test
	@Tag("next1")
	public void testSearchOutput() throws IOException {
		String[] args = {
				TEXT_FLAG, Project1Test.HELLO,
				QUERY_FLAG, Project2Test.SIMPLE, RESULTS_FLAG };

		// make sure to delete old index.json and results.json if it exists
		Files.deleteIfExists(INDEX_DEFAULT);
		Files.deleteIfExists(RESULTS_DEFAULT);

		testNoExceptions(args, SHORT_TIMEOUT);

		// make sure a results.json was NOT created
		Assertions.assertFalse(Files.exists(RESULTS_DEFAULT), debug);
	}

	/**
	 * Tests that next project functionality is not present.
	 *
	 * @throws IOException if an IO error occurs
	 */
	@Test
	@Tag("next1")
	@Tag("next2")
	public void testThreadBuild() throws IOException {
		String[] args = {
				TEXT_FLAG, TEXT_PATH.resolve("guten").toString(),
				THREADS_FLAG, "2"
		};

		try {
			// should fail and throw an error
			testMultithreaded(() -> testNoExceptions(args, LONG_TIMEOUT));
		}
		catch (AssertionFailedError e) {
			Assertions.assertNotNull(e);
			return;
		}

		// should return before here
		fail(debug);
	}

	/**
	 * Tests that next project functionality is not present.
	 *
	 * @throws IOException if an IO error occurs
	 */
	@Test
	@Tag("next1")
	@Tag("next2")
	@Tag("next3a")
	@Tag("next3b")
	public void testCrawlOutput() throws IOException {
		String seed = "https://www.cs.usfca.edu/~cs272/birds/birds.html";

		String filename = "counts-empty.json";
		Path actual = ACTUAL_PATH.resolve("index-empty.json");
		Path expected = EXPECTED_PATH.resolve("counts").resolve(filename);

		String[] args = {
				HTML_FLAG, seed, MAX_FLAG, "2",
				THREADS_FLAG, "2",
				INDEX_FLAG, actual.toString()
		};

		Executable debug = () -> checkOutput(args, actual, expected);
		Assertions.assertTimeoutPreemptively(LONG_TIMEOUT, debug);
	}
}
