'use client';
import Form from '@/component/form/Form';
import FormLabel from '@/component/form/FormLabel';
import FormInput from '@/component/form/FormInput';
import FormGroup from '@/component/form/FormGroup';
import SectionTitle from '@/component/title/SectionTitle';
import { FormEvent, useEffect, useState } from 'react';

export default function Home() {
  const [resume, setResume] = useState();

  async function onSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();

    const formData = new FormData(event.currentTarget);
    const response = await fetch('http://localhost:8080/resume', {
      method: 'POST',
      body: formData,
    });

    const data = await response.json();
  }

  async function findResume() {
    const resumeId = 'ae4541bb-dc36-4f82-b217-28d98def7ffd';
    const response = await fetch(`http://localhost:8080/resume/`, {
      method: 'GET',
    });

    // setResume(response.json());
  }

  useEffect(() => {
    findResume()
      .then((response) => {
        window.alert('ok!');
      })
      .catch((error) => {
        window.alert('not ok :(');
      });
  }, []);

  return (
    <main className="flex flex-col h-screen w-screen grow justify-items-center items-center">
      <Form key="resume-form" onSubmit={onSubmit}>
        <SectionTitle>Info</SectionTitle>
        {['Phone', 'Location', 'LinkedIn', 'WebSite'].map((field) => {
          return (
            <FormGroup className="flex flex-col">
              <FormLabel className="form">{field}</FormLabel>
              <FormInput placeholder={field} />
            </FormGroup>
          );
        })}
        <SectionTitle>Professional Experience</SectionTitle>
        {['Company 1', 'Company 2', 'Company 3'].map((field) => {
          return (
            <FormGroup className="flex flex-col">
              <FormLabel className="form">{field}</FormLabel>
              <FormInput placeholder={field} />
            </FormGroup>
          );
        })}
        <SectionTitle>Academic Experience</SectionTitle>
        {['University Example', 'Bootcamp'].map((field) => {
          return (
            <FormGroup className="flex flex-col">
              <FormLabel className="form">{field}</FormLabel>
              <FormInput placeholder={field} />
            </FormGroup>
          );
        })}
        <FormInput />
      </Form>
    </main>
  );
}
