import React, { FC } from 'react'

export interface ChildComponentProps {
  name: string;
  id: string;
}

export const ChildComponent = ({ name, id }: ChildComponentProps): JSX.Element => (
  <div>
    Hi {name} my id is {id}
  </div>
);


export const ParentComponent: FC<{ Comp: FC<ChildComponentProps> }> = ({ Comp }) =>
  <Comp name={"2"} id={"3"} />

