import { BasicProps } from '@/component/interface/BasicProps';

interface FormInputProps extends BasicProps {
  placeholder?: string;
}

export default function FormInput({ placeholder, ...props }: FormInputProps) {
  return <input type="text" placeholder={placeholder} {...props} />;
}
