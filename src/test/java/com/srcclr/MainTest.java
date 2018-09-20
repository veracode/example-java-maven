package com.srcclr;

import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class MainTest {

  void m1() {
    System.out.println("1");
  }

  void m2() {
    System.out.println("2");
  }

  void callM1() {
    for (int i=0; i<10; i++) {
      m1();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.err.println("oops1");
      }
    }
  }

  void callM2() {
    for (int i=0; i<10; i++) {
      m2();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.err.println("oops2");
      }
    }
  }

  void concurrency() throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        callM1();
      }
    });
    t1.setName("t1");
    t1.start();

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        callM2();
      }

    });
    t2.setName("t2");
    t2.start();

    t1.join();
    t2.join();
  }

  private void stdlib() {
    System.out.println("lol");
    m1();
    m2();
  }

  private void http() throws Exception {
    HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://www.google.com").openConnection();
    System.out.println(urlConnection.getRequestMethod());
  }

  static class Animal {
    public void call() {
      System.out.println("?");
    }
  }

  private void reflection() throws Exception {
    Class<?> aClass = Class.forName(Animal.class.getName());
    Object t = aClass.newInstance();

    Method[] allMethods = aClass.getDeclaredMethods();
    for (Method m : allMethods) {
      m.invoke(t);
    }
  }

  static class Cat extends Animal {
    public void call() {
      System.out.println("meow");
    }
  }

  private void dynamicDispatch() {
    Animal a = new Cat();
    a.call();
  }

  @Test
  public void test() throws Exception {
    stdlib();
    http();
    concurrency();
    reflection();
    dynamicDispatch();
    // For a test that uses a vulnerable method, see BCryptTest
  }
}
