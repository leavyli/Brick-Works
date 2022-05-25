import { useEffect, useRef, useState } from "react";

interface ITitle {
    name: string;
}

function EffectsDemoNoDependency() {
    const [title, setTitle] = useState<ITitle>({ name: 'Hello' });
    const titleRef = useRef<HTMLInputElement>(title as HTMLInputElement);
    useEffect(() => {
        console.log('useEffect');
        document.title = title.name;
    });

    const handleClick = () => {
        setTitle({ name: titleRef.current.value });
    };

    console.log('render');
    return (
        <div>
            <input ref={titleRef} />
            <button onClick={handleClick}>change title</button>
        </div>
    );
}

export default EffectsDemoNoDependency;