/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.darly.dlcommon.common.bolts.tasks;

import java.io.Closeable;

/**
 * Represents a callback delegate that has been registered with a {@link CancellationToken}.
 *
 * @see CancellationToken#register(Runnable)
 */
public class CancellationTokenRegistration implements Closeable {

  private final Object lock = new Object();
  private CancellationTokenSource tokenSource;
  private Runnable action;
  private boolean closed;

  /* package */ CancellationTokenRegistration(CancellationTokenSource tokenSource, Runnable action) {
    this.tokenSource = tokenSource;
    this.action = action;
  }

  /**
   * Unregisters the callback runnable from the cancellation token.
   */
  @Override
  public void close() {
    synchronized (lock) {
      if (closed) {
        return;
      }

      closed = true;
      tokenSource.unregister(this);
      tokenSource = null;
      action = null;
    }
  }

  /* package */ void runAction() {
    synchronized (lock) {
      throwIfClosed();
      action.run();
      close();
    }
  }

  private void throwIfClosed() {
    if (closed) {
      throw new IllegalStateException("Object already closed");
    }
  }

}
