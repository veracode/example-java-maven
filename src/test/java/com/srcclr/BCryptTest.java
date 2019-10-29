/*
 * © Copyright 2018 -  SourceClear Inc
 */
package com.srcclr;

import static junit.framework.TestCase.assertFalse;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {

  /**
   * Test for correct hashing of non-US-ASCII passwords.
   */
  @Test
  public void testInternationalChars() {
    System.out.print("BCrypt.hashpw w/ international chars: ");
    String pw1 = "ππππππππ";
    String pw2 = "????????";

    String h1 = BCrypt.hashpw(pw1, BCrypt.gensalt());
    assertFalse(BCrypt.checkpw(pw2, h1));
    System.out.print(".");

    String h2 = BCrypt.hashpw(pw2, BCrypt.gensalt());
    assertFalse(BCrypt.checkpw(pw1, h2));
    System.out.print(".");
    System.out.println("");
  }
}
