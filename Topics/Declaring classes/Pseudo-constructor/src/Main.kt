class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    val p = Point3D()
    p.x = x
    p.y = y
    p.z = z
    return p
}