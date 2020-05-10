package com.wanzhk.api.base;

import java.util.HashMap;

/**
 * RESTFul统一返回格式
 *
 * @author Wanzhk
 * <p>
 * 2020-05-08
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String message_TAG = "message";

    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type {
        /**
         * 成功，2000和前端保持一致
         */
        SUCCESS(20000),
        /**
         * 失败
         */
        FAIL(-1),
        /**
         * 警告
         */
        WARN(301),
        /**
         * 错误
         */
        ERROR(500);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    /**
     * 状态类型
     */
    private Type type;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回内容
     */
    private String message;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type    状态类型
     * @param message 返回内容
     */
    public AjaxResult(Type type, String message) {
        super.put(CODE_TAG, type.value);
        super.put(message_TAG, message);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type    状态类型
     * @param message 返回内容
     * @param data    数据对象
     */
    public AjaxResult(Type type, String message, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(message_TAG, message);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String message) {
        return AjaxResult.success(message, null);
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String message, Object data) {
        return new AjaxResult(Type.SUCCESS, message, data);
    }

    /**
     * 返回失败消息
     *
     * @return 成功消息
     */
    public static AjaxResult fail() {
        return AjaxResult.fail("操作失败");
    }

    /**
     * 返回失败消息
     *
     * @param message 返回内容
     * @return 成功消息
     */
    public static AjaxResult fail(String message) {
        return AjaxResult.fail(message, null);
    }

    /**
     * 返回失败消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 成功消息
     */
    public static AjaxResult fail(String message, Object data) {
        return new AjaxResult(Type.FAIL, message, data);
    }

    /**
     * 返回警告消息
     *
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String message) {
        return AjaxResult.warn(message, null);
    }

    /**
     * 返回警告消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String message, Object data) {
        return new AjaxResult(Type.WARN, message, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String message) {
        return AjaxResult.error(message, null);
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String message, Object data) {
        return new AjaxResult(Type.ERROR, message, data);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
