/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common.bolts.tasks.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Aggregates multiple {@code Throwable}s that may be thrown in the process of a task's execution.
 *
 * @see Task#whenAll(java.util.Collection)
 */
public class AggregateException extends Exception {
  private static final long serialVersionUID = 1L;

  private static final String DEFAULT_MESSAGE = "There were multiple errors.";

  private List<Throwable> innerThrowables;

  /**
   * Constructs a new {@code AggregateException} with the current stack trace, the specified detail
   * message and with references to the inner throwables that are the cause of this exception.
   *
   * @param detailMessage
   *            The detail message for this exception.
   * @param innerThrowables
   *            The exceptions that are the cause of the current exception.
   */
  public AggregateException(String detailMessage, Throwable[] innerThrowables) {
    this(detailMessage, Arrays.asList(innerThrowables));
  }


  /**
   * Constructs a new {@code AggregateException} with the current stack trace, the specified detail
   * message and with references to the inner throwables that are the cause of this exception.
   *
   * @param detailMessage
   *            The detail message for this exception.
   * @param innerThrowables
   *            The exceptions that are the cause of the current exception.
   */
  public AggregateException(String detailMessage, List<? extends Throwable> innerThrowables) {
    super(detailMessage,
        innerThrowables != null && innerThrowables.size() > 0 ? innerThrowables.get(0) : null);
    this.innerThrowables = Collections.unmodifiableList(innerThrowables);
  }

  /**
   * Constructs a new {@code AggregateException} with the current stack trace and with references to
   * the inner throwables that are the cause of this exception.
   *
   * @param innerThrowables
   *            The exceptions that are the cause of the current exception.
   */
  public AggregateException(List<? extends Throwable> innerThrowables) {
    this(DEFAULT_MESSAGE, innerThrowables);
  }

  /**
   * Returns a read-only {@link List} of the {@link Throwable} instances that caused the current
   * exception.
   */
  public List<Throwable> getInnerThrowables() {
    return innerThrowables;
  }

  @Override
  public void printStackTrace(PrintStream err) {
    super.printStackTrace(err);

    int currentIndex = -1;
    for (Throwable throwable : innerThrowables) {
      err.append("\n");
      err.append("  Inner throwable #");
      err.append(Integer.toString(++currentIndex));
      err.append(": ");
      throwable.printStackTrace(err);
      err.append("\n");
    }
  }

  @Override
  public void printStackTrace(PrintWriter err) {
    super.printStackTrace(err);

    int currentIndex = -1;
    for (Throwable throwable : innerThrowables) {
      err.append("\n");
      err.append("  Inner throwable #");
      err.append(Integer.toString(++currentIndex));
      err.append(": ");
      throwable.printStackTrace(err);
      err.append("\n");
    }
  }

  /**
   * @deprecated Please use {@link #getInnerThrowables()} instead.
   */
  @Deprecated
  public List<Exception> getErrors() {
    List<Exception> errors = new ArrayList<Exception>();
    if (innerThrowables == null) {
      return errors;
    }

    for (Throwable cause : innerThrowables) {
      if (cause instanceof Exception) {
        errors.add((Exception) cause);
      } else {
        errors.add(new Exception(cause));
      }
    }
    return errors;
  }

  /**
   * @deprecated Please use {@link #getInnerThrowables()} instead.
   */
  @Deprecated
  public Throwable[] getCauses() {
    return innerThrowables.toArray(new Throwable[innerThrowables.size()]);
  }

}
