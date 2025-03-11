let object = {
  a: 1,
  b: 2,
  c: 3,
};

for (let k in object) {
  console.log(k, object[k]);
}

for (let i of object) {
  console.log(i);
}
