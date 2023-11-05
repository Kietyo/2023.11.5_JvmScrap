
enum class Result {
    WIN,
    LOSE,
    DRAW
}

sealed interface Option {
    data object Rock : Option {
        override val points: Int = 1
        override fun battle(other: Option): Result {
            return when (other) {
                Paper -> Result.LOSE
                Rock -> Result.DRAW
                Scissors -> Result.WIN
            }
        }
    }
    data object Scissors : Option {
        override val points: Int = 3
        override fun battle(other: Option): Result {
            return when(other) {
                Paper -> Result.WIN
                Rock -> Result.LOSE
                Scissors -> Result.DRAW
            }
        }
    }

    data object Paper : Option {
        override val points: Int = 2
        override fun battle(other: Option): Result {
            return when(other) {
                Paper -> Result.DRAW
                Rock -> Result.WIN
                Scissors -> Result.LOSE
            }
        }
    }

    fun battle(other: Option): Result
    fun getOtherOptionToGetResult(result: Result): Option {
        return ALL.first {
            it.battle(this) == result
        }
    }
    abstract val points: Int
    companion object {
        val ALL = listOf(Rock, Paper, Scissors)
    }
}
