/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common.bolts.tasks;

/**
 * Allows safe orchestration of a task's completion, preventing the consumer from prematurely
 * completing the task. Essentially, it represents the producer side of a Task<TResult>, providing
 * access to the consumer side through the getTask() method while isolating the Task's completion
 * mechanisms from the consumer.
 */
public class TaskCompletion<TResult> {

    private final Task<TResult> task;

    /**
     * Creates a TaskCompletion that orchestrates a Task. This allows the creator of a task to
     * be solely responsible for its completion.
     */
    public TaskCompletion() {
        task = new Task<>();
    }

    /**
     * @return the Task associated with this TaskCompletion.
     */
    public Task<TResult> getTask() {
        return task;
    }

    /**
     * Sets the cancelled flag on the Task if the Task hasn't already been completed.
     */
    public boolean trySetCancelled() {
        return task.trySetCancelled();
    }

    /**
     * Sets the result on the Task if the Task hasn't already been completed.
     */
    public boolean trySetResult(TResult result) {
        return task.trySetResult(result);
    }

    /**
     * Sets the error on the Task if the Task hasn't already been completed.
     */
    public boolean trySetError(Exception error) {
        return task.trySetError(error);
    }

    /**
     * Sets the cancelled flag on the task, throwing if the Task has already been completed.
     */
    public void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /**
     * Sets the result of the Task, throwing if the Task has already been completed.
     */
    public void setResult(TResult result) {
        if (!trySetResult(result)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    /**
     * Sets the error of the Task, throwing if the Task has already been completed.
     */
    public void setError(Exception error) {
        if (!trySetError(error)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
