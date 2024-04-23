import {useEffect, useState} from "react";

function Application() {
  const [test, setTest] = useState("test");

  useEffect(() => setTest("mentuaira"), []);

  return (
    <>
      <div>{test}</div>
    </>
  )
}

export default Application;
