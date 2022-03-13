package na.severinchik.lesson5.presentation.basic

abstract class BasicUiEntity<T> {
    open fun same(entity: BasicUiEntity<T>): Boolean = false
    open fun contentSame(entity: BasicUiEntity<T>): Boolean = false
}