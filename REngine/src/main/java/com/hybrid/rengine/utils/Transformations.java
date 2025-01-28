package com.hybrid.rEngine.utils;

import com.hybrid.rEngine.math.Vector2;
import com.hybrid.rEngine.math.Vector2Int;

public class Transformations {

    //For Renderers and colliders to get the center of image or collider
    public static Vector2Int getCenterPositionWithOffsetSize(Vector2Int position, Vector2Int offset, Vector2Int size) {
        Vector2Int halfSize = new Vector2Int(
                Math.max(1, size.x / 2),
                Math.max(1, size.y / 2));

        Vector2Int center = position.subtract(halfSize);
        center.add(offset);

        return center;
    }

    public static Vector2 rotatePointAroundPivot(Vector2 point, Vector2 pivot, float angle) {
        float translatedToPivotX = point.x - pivot.x;
        float translatedToPivotY = point.y - pivot.y;

        double rotatedX = translatedToPivotX * Math.cos(angle) - translatedToPivotY * Math.sin(angle);
        double rotatedY = translatedToPivotX * Math.sin(angle) + translatedToPivotY * Math.cos(angle);

        float reverseTranslatedX = (float) rotatedX + pivot.x;
        float reverseTranslatedY = (float) rotatedY + pivot.y;

        return new Vector2(reverseTranslatedX, reverseTranslatedY);
    }

    //TODO camera transformations -> LocalToWorld, WorldToLocal
}
