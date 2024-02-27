import { BasicProps } from '@/component/interface/BasicProps';
import React from 'react';

export default function FormGroup({ children, ...props }: React.PropsWithChildren<BasicProps>) {
  return <fieldset {...props}>{children}</fieldset>;
}
