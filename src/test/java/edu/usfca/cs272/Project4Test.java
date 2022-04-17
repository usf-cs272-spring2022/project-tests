package edu.usfca.cs272;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * A test suite for project 4. During development, run individual tests instead
 * of this entire test suite!
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Spring 2022
 */
@TestMethodOrder(MethodName.class)
public class Project4Test extends ProjectTests {

	/** Primary location of the remote tests. */
	public static final String REMOTE = "https://usf-cs272-spring2022.github.io/project-web/";

	/** Location of remote tests hosted by stargate. */
	public static final String STARGATE = "https://www.cs.usfca.edu/~cs272/";
}
