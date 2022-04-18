package edu.usfca.cs272;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
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
	public class A_SimpleTests {

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
		@Tag("test4")
		public void testSimpleIndex() throws MalformedURLException {
			String seed = "input/simple/";
			testIndex(REMOTE, seed, "simple", 15);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(1)
		public void testSimpleCounts() throws MalformedURLException {
			String seed = "input/simple/";
			testCounts(REMOTE, seed, 15);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(3)
		public void testBirdsIndex() throws MalformedURLException {
			String seed = "input/birds/";
			testIndex(REMOTE, seed, "simple", 50);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(2)
		@Tag("test4")
		public void testBirdsCounts() throws MalformedURLException {
			String seed = "input/birds/";
			testCounts(REMOTE, seed, 50);
		}
	}

	/**
	 * Tests the output of this project.
	 */
	@Nested
	@TestMethodOrder(OrderAnnotation.class)
	public class A_TextTests {
		/**
		 * Tests project output.
		 *
		 * @param seed the seed URL
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Order(4)
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
		public void testRfcFiles(String seed) throws MalformedURLException {
			testIndex(REMOTE, seed, "rfcs", 1);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(5)
		public void testRfcIndex() throws MalformedURLException {
			String seed = "input/rfcs/";
			testIndex(REMOTE, seed, "rfcs", 7);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(3)
		public void testRfcCounts() throws MalformedURLException {
			String seed = "input/rfcs/";
			testCounts(REMOTE, seed, 7);
		}

		/**
		 * Tests project output.
		 *
		 * @param seed the seed URL
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Order(6)
		@ParameterizedTest
		@ValueSource(strings = {
				"input/guten/index.html",
				"input/guten/1228-h/1228-h.htm",
				"input/guten/1322-h/1322-h.htm",
				"input/guten/1400-h/1400-h.htm",
				"input/guten/1661-h/1661-h.htm",
				"input/guten/22577-h/22577-h.htm",
				"input/guten/2701-h/2701-h.htm",
				"input/guten/37134-h/37134-h.htm",
				"input/guten/50468-h/50468-h.htm"
		})
		public void testGutenFiles(String seed) throws MalformedURLException {
			testIndex(REMOTE, seed, "guten", 1);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(7)
		public void testGutenIndex() throws MalformedURLException {
			String seed = "input/guten/";
			testIndex(REMOTE, seed, "guten", 7);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(4)
		public void testGutenCounts() throws MalformedURLException {
			String seed = "input/guten/";
			testCounts(REMOTE, seed, 7);
		}
	}

	/**
	 * Tests the output of this project.
	 */
	@Nested
	@TestMethodOrder(OrderAnnotation.class)
	public class C_JavaTests {
		/**
		 * Tests project output.
		 *
		 * @param seed the seed URL
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Order(8)
		@ParameterizedTest
		@ValueSource(strings = {
				"docs/api/java.base/java/util/AbstractCollection.html",
				"docs/api/java.compiler/javax/lang/model/SourceVersion.html",
				"docs/api/java.desktop/java/awt/desktop/AboutHandler.html",
				"docs/api/java.prefs/java/util/prefs/AbstractPreferences.html",
				"docs/api/overview-tree.html",
				"docs/api/allclasses-index.html"
		})
		public void testJavaFiles(String seed) throws MalformedURLException {
			testIndex(REMOTE, seed, "java", 1);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(9)
		@Tag("test4")
		public void testJavaIndex() throws MalformedURLException {
			String seed = "docs/api/allclasses-index.html";
			testIndex(REMOTE, seed, "java", 50);
		}

		/**
		 * Tests project output.
		 *
		 * @throws MalformedURLException if unable to create seed URL
		 */
		@Test
		@Order(5)
		public void testJavaCounts() throws MalformedURLException {
			String seed = "docs/api/allclasses-index.html";
			testCounts(REMOTE, seed, 50);
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
		name = limit > 1 ? name + "-" + limit : name;

		String actualName = String.format("index-%s-%s.json", subdir, name);
		Path actualPath = ACTUAL_PATH.resolve(actualName);

		String expectedName = String.format("index-%s.json", name);
		Path expectedPath = EXPECTED_CRAWL.resolve("index-" + subdir).resolve(expectedName);

		URL base = new URL(absolute);
		URL url = new URL(base, relative);

		String[] args = {
				HTML_FLAG, url.toString(),
				MAX_FLAG, Integer.toString(limit),
				THREADS_FLAG, Integer.toString(THREADS_DEFAULT),
				INDEX_FLAG, actualPath.normalize().toString()
		};

		Assertions.assertTimeoutPreemptively(LONG_TIMEOUT, () -> {
			ProjectTests.checkOutput(args, actualPath, expectedPath);
		});
	}

	/**
	 * Runs an individual test of the web crawler inverted index output.
	 *
	 * @param absolute the base URL in absolute form
	 * @param relative the URL to fetch from the base in relative form
	 * @param limit the crawl limit to use
	 * @throws MalformedURLException if unable to create seed URL
	 */
	public static void testCounts(String absolute, String relative, int limit) throws MalformedURLException {
		String name = getTestName(relative);
		name = limit > 1 ? name + "-" + limit : name;

		String actualName = String.format("counts-%s.json", name);
		Path actualPath = ACTUAL_PATH.resolve(actualName);

		String expectedName = String.format("counts-%s.json", name);
		Path expectedPath = EXPECTED_CRAWL.resolve("counts").resolve(expectedName);

		URL base = new URL(absolute);
		URL url = new URL(base, relative);

		String[] args = {
				HTML_FLAG, url.toString(),
				MAX_FLAG, Integer.toString(limit),
				THREADS_FLAG, Integer.toString(THREADS_DEFAULT),
				COUNTS_FLAG, actualPath.normalize().toString()
		};

		Assertions.assertTimeoutPreemptively(LONG_TIMEOUT, () -> {
			ProjectTests.checkOutput(args, actualPath, expectedPath);
		});
	}

	/**
	 * Runs an individual test of the web crawler search output.
	 *
	 * @param absolute the base URL in absolute form
	 * @param relative the URL to fetch from the base in relative form
	 * @param limit the crawl limit to use
	 * @param exact whether it is an exact search
	 * @param query the query file to use
	 * @throws MalformedURLException if unable to create seed URL
	 */
	public static void testSearch(String absolute, String relative, int limit,
			boolean exact, String query) throws MalformedURLException {
		String type = exact ? "exact" : "partial";
		String name = getTestName(relative) + "-" + query.split("[.]")[0];

		String actualName = String.format("results-%s-%s.json", type, name);
		Path actualPath = ACTUAL_PATH.resolve(actualName);

		String expectedName = String.format("results-%s.json", name);
		Path expectedPath = EXPECTED_CRAWL.resolve("search-" + type).resolve(expectedName);

		URL base = new URL(absolute);
		URL url = new URL(base, relative);

		String[] args = {
				HTML_FLAG, url.toString(),
				MAX_FLAG, Integer.toString(limit),
				THREADS_FLAG, Integer.toString(THREADS_DEFAULT),
				QUERY_FLAG, QUERY_PATH.resolve(query).toString(),
				RESULTS_FLAG, actualPath.normalize().toString()
		};

		Assertions.assertTimeoutPreemptively(LONG_TIMEOUT, () -> {
			ProjectTests.checkOutput(args, actualPath, expectedPath);
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

		String[] names = last.split("[.#-]");
		String name = names[0];

		return name;
	}
}
