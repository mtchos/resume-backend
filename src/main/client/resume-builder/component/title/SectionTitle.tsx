import React, { ComponentProps, PropsWithChildren } from 'react';

interface HeadingProps extends ComponentProps<'h3'> {}

interface HeadingPropsWithChildren extends PropsWithChildren<HeadingProps> {}

export default function SectionTitle({ children, ...props }: HeadingPropsWithChildren) {
  return (
    <h3 {...props} className="font-sans font-bold text-2xl">
      {children}
    </h3>
  );
}
