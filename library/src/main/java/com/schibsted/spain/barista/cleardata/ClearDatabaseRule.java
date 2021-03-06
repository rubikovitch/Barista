package com.schibsted.spain.barista.cleardata;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This rule clears all app's Databases before running each test
 */
public class ClearDatabaseRule implements TestRule {

  @Override
  public Statement apply(final Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        clearData();
        base.evaluate();
        clearData();
      }
    };
  }

  private void clearData() {
    DatabaseOperations.clearAllDatabases(getAppContext());
  }

  private Context getAppContext() {
    return InstrumentationRegistry.getTargetContext();
  }
}