
function main() {
  const PI = Math.PI;
  let r = readLine();
  let area = PI * Math.pow(r, 2); // r * r, r ** 2
  let perimeter = 2 * PI * r;
  
  console.log(area);
  console.log(perimeter);
}