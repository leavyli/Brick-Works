import { useContext } from "react";
import { AppCtx } from "./ContextApp";

export const PostInfo = () => {
  const appContext = useContext(AppCtx);
  return (
    <div>
      Name: {appContext?.name}, Author: {appContext?.author}, Url:{" "}
      {appContext?.url}
    </div>
  );
};