LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := hellojni
LOCAL_SCR_FILES := HelloJni.c

include $(BUILD_SHARED_LIBRARY)