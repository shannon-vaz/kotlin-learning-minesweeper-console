class Task(val name: String)

object Manager {
    var solvedTask: Int = 0

    fun solveTask(t: Task) {
        println("Task ${t.name} solved!")
        solvedTask++
    }
}
