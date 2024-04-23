import {useEffect, useState} from "react";
import {PersonService} from "../service/PersonService.tsx";
import {IPerson} from "./IPerson.tsx";

export default function Person() {
  const [person, setPerson] = useState<IPerson>();

  const findAll = () => {
    PersonService.findAll()
      .then(res => {
        setPerson(res.data);
      });
  };

  useEffect(() => findAll(), []);

  return (
    <div>{person?.id.toString()}</div>
  );
}