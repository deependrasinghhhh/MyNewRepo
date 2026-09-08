/**
 * Generates the Fibonacci series up to n terms.
 * @param {number} n - The number of terms to generate.
 * @returns {number[]} The Fibonacci series array.
 */
function getFibonacciSeries(n) {
  if (n <= 0) return [];
  if (n === 1) return [0];

  const series = [0, 1];
  for (let i = 2; i < n; i++) {
    series.push(series[i - 1] + series[i - 2]);
  }
  return series;
}

// Example usage:
const terms = 10;
console.log(`Fibonacci series (${terms} terms):`, getFibonacciSeries(terms));

module.exports = { getFibonacciSeries };
