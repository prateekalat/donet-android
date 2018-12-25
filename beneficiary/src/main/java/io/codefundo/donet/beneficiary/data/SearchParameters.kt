package io.codefundo.donet.beneficiary.data

class SearchParameters private constructor() {
    companion object {
        fun generateFromIntArray(donorId: Int, array: Array<Int>) =
                mapOf(
                    "don_id" to donorId,
                    "gender" to reduceByOneOrNullIfNegative(array[0]),
                    "age_group" to reduceByOneOrNullIfNegative(array[1]),
                    "familial_status" to reduceByOneOrNullIfNegative(array[2]),
                    "disability" to reduceByOneOrNullIfNegative(array[3]),
                    "dependencies" to reduceByOneOrNullIfNegative(array[4])
                )

        private fun reduceByOneOrNullIfNegative(int: Int?): Int? {
            // If it's null then just return null. Otherwise, decrement
            val reducedInt = int?.minus(1) ?: return null

            // Negative number means "no preference". Return null in this case
            return if (reducedInt < 0) null else reducedInt
        }
    }
}