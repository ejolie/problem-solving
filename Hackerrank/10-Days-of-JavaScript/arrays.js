function getSecondLargest(num) {
  let largest = num[0];
  let secondLargest = num[0];

  for (let n of num) {
    if (n > largest) {
      secondLargest = largest;
      largest = n;
    }
    else if (n > secondLargest && n < largest) { 
      secondLargest = n;
    }
  }
  return secondLargest;
}


// return [...new Set(nums)].sort((a,b) => b-a)[1];

/*
function getSecondLargest(nums) {
    const max = Math.max(...nums)
    return Math.max(...nums.filter(x => x !== max))
}
*/

// const getSecondLargest = (nums) => 
// Math.max(...nums.filter((e) => e !== Math.max(...nums)));