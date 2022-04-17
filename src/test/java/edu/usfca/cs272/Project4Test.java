package edu.usfca.cs272;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A test suite for project 4. During development, run individual tests instead
 * of this entire test suite!
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Spring 2022
 */
@TestMethodOrder(MethodName.class)
public class Project4Test extends ProjectTests {
	// ███████╗████████╗ ██████╗ ██████╗
	// ██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗
	// ███████╗   ██║   ██║   ██║██████╔╝
	// ╚════██║   ██║   ██║   ██║██╔═══╝
	// ███████║   ██║   ╚██████╔╝██║
	// ╚══════╝   ╚═╝    ╚═════╝ ╚═╝

	/*
	 * TODO ...and read this! Please do not spam web servers by rapidly re-running
	 * all of these tests over and over again. You risk being blocked by the web
	 * server if you make making too many requests in too short of a time period!
	 *
	 * Focus on one test or one group of tests at a time instead. If you do that,
	 * you will not have anything to worry about!
	 */

	/**
	 * Tests the output of this project.
	 */
	@Nested
	@TestMethodOrder(OrderAnnotation.class)
	public class A_IndexRemoteTests {
		/**
		 * Tests project output.
		 *
		 * @param seed the seed URL
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Order(1)
		@ParameterizedTest
		@ValueSource(strings = {
				"input/simple/index.html",
				"input/simple/a/b/c/subdir.html",
				"input/simple/capital_extension.HTML",
				"input/simple/empty.html",
				"input/simple/hello.html",
				"input/simple/mixed_case.htm",
				"input/simple/position.html",
				"input/simple/stems.html",
				"input/simple/symbols.html",
				"input/simple/dir.txt"
		})
		public void testSimpleFiles(String seed) throws MalformedURLException {
			testIndex(REMOTE, seed, "simple", 1);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(2)
		public void testSimple() throws MalformedURLException {
			String seed = "input/simple/";
			testIndex(REMOTE, seed, "simple", 15);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(3)
		public void testBirds() throws MalformedURLException {
			String seed = "input/birds/";
			testIndex(REMOTE, seed, "simple", 50);
		}

		/**
		 * Tests project output.
		 *
		 * @param seed the seed URL
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Order(7)
		@ParameterizedTest
		@ValueSource(strings = {
				"input/rfcs/index.html",
				"input/rfcs/rfc3629.html",
				"input/rfcs/rfc475.html",
				"input/rfcs/rfc5646.html",
				"input/rfcs/rfc6797.html",
				"input/rfcs/rfc6805.html",
				"input/rfcs/rfc6838.html",
				"input/rfcs/rfc7231.html"
		})
		public void testRFCFiles(String seed) throws MalformedURLException {
			testIndex(REMOTE, seed, "rfcs", 1);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(8)
		public void testRFCs() throws MalformedURLException {
			String seed = "https://www.cs.usfca.edu/~cs272/rfcs/";
			testIndex(REMOTE, seed, "rfcs", 7);
		}
	}

	/** Primary location of the remote tests. */
	public static final String REMOTE = "https://usf-cs272-spring2022.github.io/project-web/";

	/** Location of remote tests hosted by stargate. */
	public static final String STARGATE = "https://www.cs.usfca.edu/~cs272/";

	/** Where to locate expected files for web crawling. */
	public static final Path EXPECTED_CRAWL = EXPECTED_PATH.resolve("crawl");

	/** The default number of threads to use when benchmarking. */
	public static final int BENCH_THREADS = 5;

	/**
	 * Runs an individual test of the web crawler inverted index output.
	 *
	 * @param absolute the base URL in absolute form
	 * @param relative the URL to fetch from the base in relative form
	 * @param subdir the subdir to use for expected output
	 * @param limit the crawl limit to use
	 * @throws MalformedURLException if unable to create seed URL
	 */
	public static void testIndex(String absolute, String relative, String subdir, int limit) throws MalformedURLException {
		String name = getTestName(relative);
		String filename = String.format("index-%s.json", name);

		Path actual = ACTUAL_PATH.resolve(filename);
		Path expected = EXPECTED_CRAWL.resolve("index-" + subdir).resolve(filename);

		URL base = new URL(absolute);
		URL url = new URL(base, relative);

		String[] args = { HTML_FLAG, url.toString(), MAX_FLAG, Integer.toString(limit),
				THREADS_FLAG, Integer.toString(THREADS_DEFAULT), INDEX_FLAG,
				actual.normalize().toString() };

		Assertions.assertTimeoutPreemptively(LONG_TIMEOUT, () -> {
			ProjectTests.checkOutput(args, actual, expected);
		});
	}

	/**
	 * Gets the name to use for test output files based on the link.
	 *
	 * @param link the link to test
	 * @return the name to use for test output
	 */
	public static String getTestName(String link) {
		String[] paths = link.split("/");
		String last = paths[paths.length - 1];
		String[] parts = last.split("[.#-]");
		return parts[0];
	}
}
