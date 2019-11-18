LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := Hello
LOCAL_SRC_FILES := com_zhujohnle_androidreplay_ndk_Test.c
include $(BUILD_SHARED_LIBRARY)