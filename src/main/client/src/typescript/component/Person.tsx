import {useEffect, useState} from "react";
import {PersonService} from "../service/PersonService.tsx";
import {IPerson} from "./IPerson.tsx";

export default function Person() {
    const [person, setPerson] = useState<IPerson>();

    const findAll = () => {
        PersonService.findAll()
            .then(res => {
                const onePerson = res.data[0];
                setPerson(onePerson);
            });
    };

    useEffect(() => findAll(), []);

    return (
        <>
            <div>id: {person?.id.toString()}</div>
            <div>email: {person?.email?.toString()}</div>
            <div>username: {person?.username?.toString()}</div>
            <div>password: {person?.password?.toString()}</div>
            {person?.resumes?.map((index, resume) => {
                return (
                    <div>resume {index + 1}: {resume.toString()}</div>
                );
            })}
        </>
    );
}