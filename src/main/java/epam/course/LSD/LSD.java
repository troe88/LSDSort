package epam.course.LSD;

import java.util.Random;

public class LSD {
	private final static int BITS_PER_BYTE = 8;
	private static int max_ = 10000;

	/**
	 * <p>
	 * Set max value of random numbers
	 * </p>
	 * 
	 * @author Dmitry Lebedev
	 * @version 1.0 beta
	 * @param max
	 *            new max_ value
	 */
	public static void setMax(int max) {
		max_ = max;
	}

	/**
	 * <p>
	 * Generate array with random integer numbers
	 * </p>
	 * <p>
	 * Method generate array with random integer signed or/and unsigned numbers.
	 * </p>
	 * 
	 * @author Dmitry Lebedev
	 * @version 1.0 beta
	 * @param arr
	 *            Input array
	 * @param is_negative
	 *            if set to true, generate array with signed integer
	 */
	public static void genRandArray(int[] arr, boolean is_negative) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			if (is_negative)
				arr[i] = rand.nextInt(max_ * 2) - max_;
			else
				arr[i] = rand.nextInt(max_);
		}
	}

	/**
	 * <p>
	 * Sort 32-bit integer array by LSD string method.
	 * </p>
	 * <p>
	 * This work was performed on the basis of "Robert Sedgwick, Kevin Wayne"
	 * Algorithms for Java ", 4th edition". Method public static void sort (int
	 * [] src) implements sorting integer signed and unsigned 32-bit integers.
	 * </p>
	 * 
	 * @author Dmitry Lebedev
	 * @version 1.0 beta
	 * @param src
	 *            Input array
	 */
	public static void sort(int[] src) {
		int W = 32 / BITS_PER_BYTE; // sizeof(int)
		int R = 256; // один байт кодирует 0-256
		int MASK = 0xFF; // для каждой терации нужно взять только последние 8
							// бит
		int N = src.length; // длина входящего массива
		int[] aux = new int[N]; // вспомогательный массив

		int neg_count = 0; // счетчик отрицательныйх чисел

		// Сортировка 32-bit целых чисел
		// Сортируем каждые 8 бит числа начиная с конца
		for (int d = 0; d < W; d++) {

			// Вспомогательный масси для хранения кол-ва индексов.
			int[] count = new int[R + 1];

			// Проходим по начальному массиву, и
			// 1. если число отрицательное, увеличиваем счетчик на 1
			// 2. сдвигаем начальное число на 8 * номер_итерации и берем
			// последние 8 бит
			// 3. в счетчике индексов увеличиваем полученный в п.2 индекс на 1
			for (int i = 0; i < N; i++) {
				if (src[i] < 0)
					neg_count++;

				int temp = (src[i] >> BITS_PER_BYTE * d) & MASK;
				count[temp + 1]++;
			}

			// Преобразовываем индексы в счетчике индексов в реальные индексы
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// Заполняем вспомогательный массив реальными данными солгаснго
			// счетчику индексов
			for (int i = 0; i < N; i++) {
				int temp = (src[i] >> BITS_PER_BYTE * d) & MASK;
				aux[count[temp]++] = src[i];
			}

			// Копируем значения из вспомогательного массива в исходный
			System.arraycopy(aux, 0, src, 0, N);
		}

		// Вычисляем реальное количество отрицательных э-тов
		neg_count /= W;

		// Если в массиве всего 1 отрицательный элемент, выполняем перестановку
		// 0 и последнего э-та
		if (neg_count == 1) {
			int temp = src[N - 1];
			src[N - 1] = src[0];
			src[0] = temp;
		}
		// Если в массиве более 1 отрицательного элемента, то
		// 1. Создаем вспомогательный массив n_temp для отрицательных элементов
		// 2. Копируем все отрицальные элементы из исходного отсортированного
		// массива src в вспомогательный массив n_temp
		// 3. Смещаем все положительные элементы в конец исходного
		// отсортированного массива src
		// 4. Копируем все элементы из вспомогательного массива n_temp в
		// исходный отсортированный массив src
		else if (neg_count > 1) {
			int[] n_temp = new int[neg_count];
			int p = N - neg_count;
			System.arraycopy(src, p, n_temp, 0, neg_count);
			System.arraycopy(src, 0, src, neg_count, p);
			System.arraycopy(n_temp, 0, src, 0, neg_count);
		}
	}
}
