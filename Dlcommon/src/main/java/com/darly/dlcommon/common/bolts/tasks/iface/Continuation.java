/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common.bolts.tasks.iface;


import com.darly.dlcommon.common.bolts.tasks.Task;

/**
 * A function to be called after a task completes.
 * <p>
 * If you wish to have the Task from a Continuation that does not return a Task be cancelled
 * then throw a {@link java.util.concurrent.CancellationException} from the Continuation.
 *
 * @see Task
 */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> task) throws Exception;
}
