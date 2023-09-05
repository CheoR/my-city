package com.example.mycity.utils


/**
 * Content shown depending on size and state of device.
 */

enum class ScreenNavigationType {
    BOTTOM_NAVIGATION,
    NAVIGATION_RAIL,
    PERMANENT_NAVIGATION_DRAWER,
}

enum class ScreenContentType {
    DETAIL, // Mobile protrait
    LIST_ONLY, // default
    LIST_AND_DETAIL, // expanded screen
}
