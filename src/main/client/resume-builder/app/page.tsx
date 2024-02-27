import Form from '@/component/form/Form';
import FormLabel from '@/component/form/FormLabel';
import FormInput from '@/component/form/FormInput';
import FormGroup from '@/component/form/FormGroup';
import SectionTitle from '@/component/title/SectionTitle';

export default function Home() {
  return (
    <main className="flex flex-col h-screen w-screen grow justify-items-center items-center">
      <Form key="resume-form">
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
      </Form>
    </main>
  );
}
