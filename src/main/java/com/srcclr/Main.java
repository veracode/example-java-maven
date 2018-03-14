package com.srcclr;

import org.mindrot.jbcrypt.BCrypt;

public class Main {

  public static void main(String[] args) {
    String candidate = args[0];
    String salt = BCrypt.gensalt(12);
    String hashed = BCrypt.hashpw(candidate, salt);

    BCrypt.checkpw(candidate, hashed);

    harmless();
  }

  static void harmless() {
    BCrypt.checkpw("candidate", "hash");
  }
}
